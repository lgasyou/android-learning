package bit.lizeqing.broadcastbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            val username = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            accountEditText.setText(username)
            passwordEditText.setText(password)
            rememberPass.isChecked = true
        }

        loginButton.setOnClickListener {
            val account = accountEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (account == "123456" && password == "123456") {
                val editor = getPreferences(Context.MODE_PRIVATE).edit()
                if (rememberPass.isChecked) {
                    editor.apply {
                        putString("account", account)
                        putString("password", password)
                        putBoolean("remember_password", rememberPass.isChecked)
                        apply()
                    }
                } else {
                    editor.clear().apply()
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Account or password error", Toast.LENGTH_SHORT).show()
            }
        }

    }
}