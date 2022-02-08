package app.el_even.jcdecaux.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.el_even.jcdecaux.presentation.station_detail.StationDetailScreen
import app.el_even.jcdecaux.presentation.station_list.StationListScreen
import app.el_even.jcdecaux.presentation.ui.theme.JCDecauxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			JCDecauxTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					val navController = rememberNavController()
					NavHost(
						navController = navController,
						startDestination = Screen.MainScreen.route
					) {
						composable(
							route = Screen.MainScreen.route
						) {
							StationListScreen(navController)
						}
						composable(
							route = Screen.StationScreen.route + "/{number}/{contract}",
						) {
							StationDetailScreen()
						}
					}
				}
			}
		}
	}
}
