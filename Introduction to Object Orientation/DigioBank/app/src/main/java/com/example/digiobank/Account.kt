package com.example.digiobank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import com.example.digiobank.domain.Account
import java.math.BigDecimal

@Composable
fun AccountList(accountViewModel: AccountViewModel = viewModel()) {
    val accountList by accountViewModel.accountFlow.collectAsState()
    val depositMessage by accountViewModel.showDepositMessage.collectAsState()
    val withDrawMessage by accountViewModel.showWithdrawMessage.collectAsState()
    accountList?.let { accounts ->
        AccountList(
            accountList = accounts,
            deposit = { accountId, value -> accountViewModel.deposit(accountId, value) },
            withDraw = { accountId, value -> accountViewModel.withDraw(accountId, value) }
        )
    }
    depositMessage?.let {
    }
    withDrawMessage?.let {
    }
}

@Composable
fun AccountList(
    accountList: List<Account>,
    deposit: (String, BigDecimal) -> Unit,
    withDraw: (String, BigDecimal) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        item("Header") {
            Text(
                text = "Accounts",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        items(accountList) { account ->
            Account(
                account = account,
                deposit = deposit,
                withDraw = withDraw
            )
        }
    }
}

@Preview
@Composable
fun AccountListPreview() {
    AccountList(
        accountList = listOf(
            Account("82839", "8234034-5", BigDecimal.valueOf(379328)),
            Account("828656", "8657764-5", BigDecimal.valueOf(7563466))
        ),
        deposit = { _, _ -> },
        withDraw = { _, _ -> }
    )
}

@Composable
fun Account(
    account: Account,
    deposit: (String, BigDecimal) -> Unit,
    withDraw: (String, BigDecimal) -> Unit
) {
    Column() {
        Text(text = "Agency: ${account.agency}")
        Text(text = "Account Number: ${account.accountNumber}")
        Text(text = "Balance: ${account.balance.convertToCurrency()}")

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = {
                deposit(account.accountNumber, BigDecimal.valueOf(1000))
            }) {
                Text(text = "Deposit")
            }

            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .height(0.dp)
            )

            Button(onClick = {
                if (account.balance > BigDecimal.valueOf(0)) {
                    withDraw(account.accountNumber, BigDecimal.valueOf(300))
                }
            }) {
                Text(text = "WithDraw")
            }
        }
    }
}

@Preview()
@Composable
fun AccountPreview() {
    Account(
        account = Account(
            agency = "8393",
            accountNumber = "8393930-0",
            balance = BigDecimal.valueOf(532523)
        ),
        deposit = { _, _ -> },
        withDraw = { _, _ -> }
    )
}