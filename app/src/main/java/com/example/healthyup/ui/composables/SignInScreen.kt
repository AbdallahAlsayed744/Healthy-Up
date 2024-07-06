package com.example.healthyup.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyup.R


@Composable

fun SignInScreen(){

    SignInScreenBody()


}

@Composable
fun SignInScreenBody() {

    Column(modifier = Modifier
        .padding(top = 50.dp)
        .fillMaxSize()) {
        Text(text = "Log In", modifier =Modifier.fillMaxWidth(), textAlign = TextAlign.Center ,fontSize = 25.sp, fontWeight = FontWeight.Bold,color = colorResource(
            id = R.color.primarycolor))


        Text(text = "Welcome", modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth() , textAlign = TextAlign.Center,fontSize = 22.sp,color = colorResource(
            id = R.color.primarycolor))


        Text(text = "Email", modifier = Modifier
            .padding(top = 40.dp, start = 30.dp)
            .fillMaxWidth() ,fontSize = 22.sp,color = colorResource(
            id = R.color.black))

        Mytextfield(modifier = Modifier
            .padding(start = 30.dp)
            .fillMaxWidth(0.9f), hint = "Enter Email"){

        }

        Text(text = "Password", modifier = Modifier
            .padding(top = 10.dp, start = 30.dp)
            .fillMaxWidth() ,fontSize = 22.sp,color = colorResource(
            id = R.color.black))

        MytextfieldPassword(modifier = Modifier
            .padding(start = 30.dp)
            .fillMaxWidth(0.9f), hint = "Enter Password"){

        }

        Text(text = "Forget Password", modifier = Modifier
            .padding(top = 5.dp, end = 34.dp)
            .fillMaxWidth() , textAlign = TextAlign.End,fontSize = 16.sp,color = colorResource(
            id = R.color.primarycolor), fontWeight = FontWeight.Bold)


        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(15.dp),colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(
                id = R.color.primarycolor
            ),
            contentColor = Color.White

        ), modifier = Modifier
            .padding(top = 50.dp, start = 100.dp)
            .fillMaxWidth(0.7f)
            .height(50.dp)
        )
        {

            Text(text = "Log In", fontSize = 20.sp)
        }

        Text(text = "or sign up with", modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth() , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
            id = R.color.black) )

        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Box(modifier = Modifier){
                Image(painter = painterResource(id = R.drawable.ring), contentDescription ="ring")
                Image(painter = painterResource(id = R.drawable.google), modifier = Modifier.padding(top=10.dp, start = 10.dp),contentDescription ="google")

            }

            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.facebook),contentDescription ="facebook", modifier = Modifier.size(37.dp))


        }

        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.Center) {

            Text(text = "Don't have an account?", modifier = Modifier
                , textAlign = TextAlign.Center,fontSize = 16.sp,color = colorResource(
                id = R.color.black) )
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Sign Up", modifier = Modifier
                , textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 16.sp,color = colorResource(
                    id = R.color.primarycolor) )


        }









    }
}

@Composable
fun Mytextfield(modifier: Modifier = Modifier, hint: String,onSearch:(String)->Unit) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = modifier.padding(vertical = 15.dp)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(15.dp)),
            value = text,
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {
                text = it
                onSearch(it)
            },

            maxLines = 1,
            prefix = {

            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

}

@Composable
fun MytextfieldPassword(modifier: Modifier = Modifier, hint: String,onSearch:(String)->Unit) {

    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = modifier.padding(vertical = 15.dp)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(15.dp)),
            value = text,
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {
                text = it
                onSearch(it)
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {

                    Icon(
                         painter = painterResource(id = if (showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription ="Toggle Password Visibility"

                    )



                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1,
            prefix = {

            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignInScreenPreview() {
//    SignInScreen()
//}
