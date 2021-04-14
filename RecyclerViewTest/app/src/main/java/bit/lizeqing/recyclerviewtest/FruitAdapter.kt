package bit.lizeqing.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class Fruit(val fruitName: String, val fruitImageId: Int)

class FruitAdapter(private val fruitList: List<Fruit>) :
        RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName: TextView = view.findViewById(R.id.fruitName)
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        val holder = ViewHolder(view)
        holder.fruitImage.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList[position]
            Toast
                .makeText(parent.context, "You clicked image ${fruit.fruitName}", Toast.LENGTH_SHORT)
                .show()
        }
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList[position]
            Toast
                .makeText(parent.context, "You clicked text ${fruit.fruitName}", Toast.LENGTH_SHORT)
                .show()
        }
        return holder
    }

    override fun getItemCount() = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.fruitName
        holder.fruitImage.setImageResource(fruit.fruitImageId)
    }

}