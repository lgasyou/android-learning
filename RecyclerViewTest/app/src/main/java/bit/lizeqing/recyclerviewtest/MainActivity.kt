package bit.lizeqing.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.lang.StringBuilder

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
            fruitList.add(Fruit(getRandomLengthString("apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..10).random()
        return buildString {
            repeat(n) {
                this.append(str)
            }
        }
    }

}