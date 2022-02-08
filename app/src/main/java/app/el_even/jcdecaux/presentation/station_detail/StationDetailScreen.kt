package app.el_even.jcdecaux.presentation.station_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import timber.log.Timber

@Composable
fun StationDetailScreen(
	viewModel: StationDetailViewModel = hiltViewModel()
) {
	val state = viewModel.state.value
	Timber.d("Station: $state")
	Column(modifier = Modifier.fillMaxWidth()) {
		state.station?.let { station ->
			Text(text = station.name)
			Spacer(modifier = Modifier.height(15.dp))
			Text(text = station.status)
			Spacer(modifier = Modifier.height(15.dp))
			Text(text = "Available stand: ${station.available_bike_stands}")
			Spacer(modifier = Modifier.height(15.dp))

		}
	}

	if (state.error.isNotBlank()) {
		Text(
			text = state.error,
			color = MaterialTheme.colors.error,
			textAlign = TextAlign.Center,
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 20.dp)
		)
	}

	if (state.isLoading) {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			CircularProgressIndicator(progress = 0.5f)
		}
	}
}