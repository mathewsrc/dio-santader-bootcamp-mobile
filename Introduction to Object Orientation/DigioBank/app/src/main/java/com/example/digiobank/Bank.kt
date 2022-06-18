package com.example.digiobank

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.digiobank.domain.Bank

@Composable
fun Bank(bankViewModel: BankViewModel= viewModel()) {
    val bank by bankViewModel.bankFlow.collectAsState()
    bank?.let { bank ->
        Bank(bank = bank)
    }
}

@Composable
fun Bank(bank: Bank) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(
            text = "Bank",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Name: ${bank.name}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Number: ${bank.number}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun BankPreview() {
    MaterialTheme() {
        Bank(Bank(name = "DigioOneBank", number = 839289))
    }
}