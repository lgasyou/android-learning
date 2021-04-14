package bit.lizeqing.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("apple", R.drawable.apple_pic))
            fruitList.add(Fruit("banana", R.drawable.banana_pic))
            fruitList.add(Fruit("orange", R.drawable.orange_pic))
            fruitList.add(Fruit("watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("pear", R.drawable.pear_pic))
            fruitList.add(Fruit("grape", R.drawable.grape_pic))
            fruitList.add(Fruit("pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("mango", R.drawable.mango_pic))
        }
    }
}