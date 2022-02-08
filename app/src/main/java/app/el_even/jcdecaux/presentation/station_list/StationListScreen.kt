package app.el_even.jcdecaux.presentation.station_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.el_even.jcdecaux.presentation.Screen
import app.el_even.jcdecaux.presentation.station_list.component.StationListItem
import timber.log.Timber

@Composable
fun StationListScreen(
	navController: NavController,
	viewModel: StationListViewModel = hiltViewModel()
) {
	val state = viewModel.state.value
	LazyColumn(modifier = Modifier.fillMaxSize()) {
		items(state.stations) { station ->
			Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(4.dp)) {
				StationListItem(station = station, onItemClick = {
					navController.navigate(Screen.StationScreen.route + "/${station.number}/${station.contract_name}")
				})
			}
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