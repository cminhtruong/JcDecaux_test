package app.el_even.jcdecaux.presentation.station_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.el_even.jcdecaux.common.Resource
import app.el_even.jcdecaux.domain.interactor.get_station.GetStationUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StationDetailViewModel @Inject constructor(
	savedStateHandle: SavedStateHandle,
	private val getStationUC: GetStationUC
) : ViewModel() {

	private val _state = mutableStateOf(StationDetailState())
	val state: State<StationDetailState> = _state

	private val number = savedStateHandle.get<String>("number") ?: ""
	private val contract = savedStateHandle.get<String>("contract") ?: ""

	init {
		Timber.d("number = $number and contract = $contract")
		getStation(number.toInt(), contract)
	}

	private fun getStation(number: Int, contract: String) {
		getStationUC(number, contract).onEach { result ->
			when (result) {
				is Resource.Error -> _state.value =
					StationDetailState(error = result.message ?: "An unexpected error from result")
				is Resource.Loading -> _state.value = StationDetailState(isLoading = true)
				is Resource.Success -> _state.value = StationDetailState(station = result.data)
			}
		}.launchIn(viewModelScope)
	}
}