package com.example.kotlindemo.JetPackComposed.RentHouse.Ui.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.UserResponce
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


@Composable
fun Travo_HomeScreen() {

    val navController = rememberNavController()

    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

//    LaunchedEffect(true) {
//        // Fetch user data when the component is first launched
//        userList = fetchUserData()
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {


//        Text(
//            text = "User List",
//            style = typography.headlineMedium,
//            modifier = Modifier.alpha(1f)
//        )

        // Display user data in a LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {


            items(state) { user: UserResponce ->
                UserListItem(user = user)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListItem(user: UserResponce) {

    Column(Modifier.fillMaxWidth().padding(5.dp)) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            onClick = { },
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.White)
                .align(Alignment.CenterHorizontally),
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically

            ) {
                // Display user image

                GlideImage(
                    imageModel = { user.avatar }, // loading a network image using an URL.
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
//            alignment = Alignment.Center

                    ),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .height(50.dp)
                        .width(50.dp)
                        .padding(2.dp),

                    )

                Spacer(modifier = Modifier.width(8.dp))
                Column(Modifier.fillMaxWidth()) {
                    // Display user name
                    Text(
                        text = "${user.firstName}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "${user.address.streetAddress + user.address.streetName + user.address.state}",
                        fontSize = 8.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}


// Placeholder function to fetch user data from an API
//private suspend fun fetchUserData(): List<UserResponce> {
//    // Replace this URL with your actual API endpoint
//    val apiUrl = "https://random-data-api.com/api/v2/users?size=10&is_xml=true"
//
//    return try {
//        val jsonString = withContext(Dispatchers.IO) {
//            val url = URL(apiUrl)
//            val connection = url.openConnection() as HttpURLConnection
//
//            connection.requestMethod = "GET"
//            connection.connectTimeout = 5000
//            connection.readTimeout = 5000
//
//            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
//                val inputStream = connection.inputStream
//                inputStream.bufferedReader().use { it.readText() }
//            } else {
//                // Handle error cases
//                ""
//            }
//        }
//
//        // Parse the JSON response and create a list of UserData
//        parseJsonResponse(jsonString)
//    } catch (e: IOException) {
//        // Handle network or parsing errors
//        emptyList()
//    }
//}


// Placeholder function to parse JSON response and create a list of UserData
//private fun parseJsonResponse(jsonString: String): List<UserResponce> {
//    val userList = mutableListOf<UserResponce>()
//
//    try {
////        val jsonObject = JSONArray(jsonString)
//
//        val array = JSONArray(jsonString)
//        for (i in 0 until array.length()) {
//            val userObject = array.getJSONObject(i)
//            val uid = userObject.getString("uid")
//            val firstname = userObject.getString("first_name")
//            val last_name = userObject.getString("last_name")
//            val username = userObject.getString("username")
//            val email = userObject.getString("email")
//            val avatar = userObject.getString("avatar")
//                val gender = userObject.getString("gender")
//            val phone_number = userObject.getString("phone_number")
//            val social_insurance_number = userObject.getString("social_insurance_number")
//            val date_of_birth = userObject.getString("date_of_birth")
//
////            get employment data
//            val employment = userObject.getJSONObject("employment")
//            val title = employment.getString("title")
//            val key_skill = employment.getString("key_skill")
//            val employmentobj = Employment(title = title, keySkill = key_skill)
//
//            val address = userObject.getJSONObject("address")
//            val city = address.getString("city")
//            val street_name = address.getString("street_name")
//            val street_address = address.getString("street_address")
//            val zip_code = address.getString("zip_code")
//                val state = address.getString("state")
//            val country = address.getString("country")
//            val coordinates = address.getJSONObject("coordinates")
//
//            val lat = coordinates.getString("lat")
//            val lng = coordinates.getString("lng")
//
//            val addressobj = Address(
//                city = city,
//                streetName = street_name,
//                streetAddress = street_address,
//                zipCode = zip_code,
//                state = state,
//                country = country
//            )
//
//
//            val userData = UserResponce(
//                uid = uid,
//                firstName = firstname,
//                lastName = last_name,
//                username = username,
//                email = email,
//                avatar = avatar,
//                gender = gender,
//                phoneNumber = phone_number,
//                socialInsuranceNumber = social_insurance_number,
//                dateOfBirth = date_of_birth,
//                employment = employmentobj,
//                address = addressobj
//            )
//            userList.add(userData)
//        }
//
//
//    } catch (e: Exception) {
//        // Handle parsing exceptions
//        e.printStackTrace()
//    }
//
//    return userList
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun demo1() {
    Column(Modifier.fillMaxWidth()) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            onClick = { },
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.White)
                .align(Alignment.CenterHorizontally),
            shape = MaterialTheme.shapes.medium

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically

            ) {
                // Display user image

//                GlideImage(
//                    imageModel = { "https://robohash.org/quisquamsequinemo.png?size=300x300&set=set1" }, // loading a network image using an URL.
//                    imageOptions = ImageOptions(
//                        contentScale = ContentScale.Crop,
////            alignment = Alignment.Center
//
//                    ),
//                    modifier = Modifier
//                        .aspectRatio(1f)
//                        .height(50.dp)
//                        .width(50.dp)
//                        .padding(2.dp),
//
//                    )

                Spacer(modifier = Modifier.width(8.dp))
                Column(Modifier.fillMaxWidth()) {
                    // Display user name
                    Text(
                        text = "Harhsil",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "address",
                        fontSize = 8.sp
                    )
                }
            }
        }
//        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
//    Travo_HomeScreen()
    demo1()
}



