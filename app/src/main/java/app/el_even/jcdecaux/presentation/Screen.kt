package app.el_even.jcdecaux.presentation

sealed class Screen(val route: String) {
	object MainScreen : Screen("main")
	object StationScreen : Screen("station")
}