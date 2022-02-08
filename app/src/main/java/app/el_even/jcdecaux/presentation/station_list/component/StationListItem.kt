package app.el_even.jcdecaux.presentation.station_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.el_even.jcdecaux.domain.model.Station

@Composable
fun StationListItem(station: Station, onItemClick: (Station) -> Unit) {
	Row(modifier = Modifier
		.fillMaxWidth()
		.clickable { onItemClick(station) }
		.padding(20.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text(text = station.name)
	}
}