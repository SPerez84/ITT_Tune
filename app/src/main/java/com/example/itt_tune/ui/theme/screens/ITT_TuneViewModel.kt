import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.itt_tune.data.ITT_TuneRepository
import com.example.itt_tune.IttTuneApplication
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ITTTuneUIState {
    data class Success(val translation: String) : ITTTuneUIState
    object Error : ITTTuneUIState
    object Loading : ITTTuneUIState
}

class ITT_TuneViewModel(
    private val ittTranslationRepository: ITT_TuneRepository
) : ViewModel(){
    /*var ittTuneUiState: ITTTuneUIState by mutableStateOf(ITTTuneUIState.Loading)
        private set*/

    private var _ittTuneUiState = MutableLiveData<ITTTuneUIState>(ITTTuneUIState.Loading)
    var ittTuneUiState: LiveData<ITTTuneUIState> = _ittTuneUiState

    init {
        _ittTuneUiState.value = ITTTuneUIState.Loading
    }
    fun getAzureResponse(userInput: String) {
        viewModelScope.launch {
            _ittTuneUiState.postValue(ITTTuneUIState.Loading)
            try {
                val listResult = ittTranslationRepository.getAzureResponse(userInput)
                _ittTuneUiState.postValue(
                    ITTTuneUIState.Success(listResult.firstOrNull() ?: "")
                )
            } catch (e: IOException) {
                _ittTuneUiState.postValue(ITTTuneUIState.Error)
            } catch (e: HttpException) {
                _ittTuneUiState.postValue(ITTTuneUIState.Error)
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as IttTuneApplication)
                val ittTranslationRepository = application.container.ittTunerepository
                ITT_TuneViewModel(ittTranslationRepository = ittTranslationRepository)
            }
        }
    }

}