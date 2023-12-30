package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun ContactColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom
    )  {
        ContactRow(
            icon = Icons.Rounded.Phone,
            modifier = modifier,
            text = stringResource(R.string.phone_contact_text)
        )
        ContactRow(
            icon = Icons.Rounded.Home,
            modifier = modifier,
            text = stringResource(R.string.social_contact_text)
        )
        ContactRow(
            icon = Icons.Rounded.Email,
            modifier = modifier,
            text = stringResource(R.string.email_contact_text)
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, modifier: Modifier, text: String) {
    Row(
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = modifier.weight(weight = 1f),
        ) {
            Icon(
                contentDescription = null,
                imageVector = icon,
                modifier = modifier,
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(start = 12.dp).weight(weight = 2f),
        ) {
            Text(
                modifier = modifier,
                text = text,
            )
        }
    }
}

@Composable
fun IdentityColumn(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            contentDescription = null,
            imageVector = Icons.Rounded.AccountCircle,
            modifier = modifier,
        )

        Text(
            text = stringResource(id = R.string.name_text),
            modifier = modifier,
        )

        Text(
            text = stringResource(R.string.role_title_text),
            modifier = modifier,
        )
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column {
        Row(modifier = modifier.weight(weight = 0.6f)) {
            IdentityColumn(modifier = modifier)
        }
        Row(modifier = modifier.weight(weight = 0.4f)) {
            ContactColumn(modifier = modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        MainContent()
    }
}