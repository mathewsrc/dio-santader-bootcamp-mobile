package com.example.digiobank

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.digiobank.ui.theme.DigioBankTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val personViewModel by viewModels<PersonViewModel>()
    private val bankViewModel by viewModels<BankViewModel>()
    private val accountViewModel by viewModels<AccountViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigioBankTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                accountViewModel.showDepositMessage.collectLatest {
                    it?.let {
                        Toast(this@MainActivity).setText("You deposited ${it.toLong()}")
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                accountViewModel.showWithdrawMessage.collectLatest {
                    it?.let {
                        Toast(this@MainActivity).setText("You withdrew ${it.toLong()}")
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Digio One bank",
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Person()
        Bank()
        AccountList()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DigioBankTheme {
        MainScreen()
    }
}

