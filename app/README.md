# MainActivity:
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
```

# Permiso a internet (AndroidManifest.xml):
```
<uses-permission android:name="android.permission.INTERNET" />
```

# Retrofit:
com.squareup.retrofit2 (retrofit y gson)

# Navigation:
navigation-compose

# Base de datos:
room-runtime (version 2.6.1)
room-compiler (version 2.6.1)
*en build.gradle, agregar: annotationProcessor(libs.androidx.room.compiler) en vez del implementation

# Estados:
```
val username = remember {
    mutableStateOf("")
}
```

ejm:
```
val navController = rememberNavController()
NavHost(navController = navController, startDestination = Routes.RestaurantList.route) {

    composable(Routes.SignIn.route) {
        SignInScreen {
            navController.navigate(Routes.SignUp.route)
        }
    }
    composable(Routes.SignUp.route) {
        SignUpScreen()
    }
    composable(Routes.RestaurantList.route) {
        RestaurantListScreen()
    }
}
```