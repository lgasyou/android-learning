package bit.lizeqing.uibestpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val msgView: TextView = view.findViewById(R.id.leftMsg)
    }

    inner class RightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val msgView: TextView = view.findViewById(R.id.rightMsg)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Msg.TYPE_RECEIVED -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.msg_left_item, parent, false)
                LeftViewHolder(view)
            }
            Msg.TYPE_SENT -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.msg_right_item, parent, false)
                RightViewHolder(view)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> {
                holder.msgView.text = msg.content
            }
            is RightViewHolder -> {
                holder.msgView.text = msg.content
            }
            else -> throw IllegalArgumentException()
        }
    }

}