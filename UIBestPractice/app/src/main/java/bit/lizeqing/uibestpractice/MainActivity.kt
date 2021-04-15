package bit.lizeqing.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val msgList = mutableListOf<Msg>()
    private lateinit var test: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMsg()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter

        send.setOnClickListener {
            val input = inputText.text.toString()
            if (input.isNotEmpty()) {
                msgList.add(Msg(input, 1))
                adapter.notifyItemInserted(msgList.size - 1)
                recyclerView.scrollToPosition(msgList.size - 1)
                inputText.setText("")
            }
        }
    }

    private fun initMsg() {
        msgList.add(Msg("Hello, world", Msg.TYPE_SENT))
        msgList.add(Msg("Hello, world", Msg.TYPE_RECEIVED))
    }

}