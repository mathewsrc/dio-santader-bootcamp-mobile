package com.example.digiobank

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.digiobank.domain.Person

@Composable
fun Person(personViewModel: PersonViewModel = viewModel()) {
    val person by personViewModel.person.collectAsState()
    person?.let { person ->
        Person(person)
    }
}

@Composable
fun Person(person: Person) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = person.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Social Number: ${person.socialId}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun PersonPreview() {
    MaterialTheme() {
        Person(person = Person())
    }
}
