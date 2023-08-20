package co.aladinjunior.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.model.Snack
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val snacks = listOf(
            Snack(
                id = 1,
                icon = R.drawable.hamburguer_black,
                name = "Hambúrguer Black",
                price = 30.0
            ),
            Snack(
                id = 2,
                icon = R.drawable.hamburguer_normal,
                name = "Hambúrguer Simples",
                price = 20.0
            )
        )



        val adapter = Adapter(snacks)
        val rv = findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        

    }


    private inner class Adapter(private val orderList: List<Snack>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.snack_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentItem = orderList[position]
            holder.bind(currentItem)
        }

        override fun getItemCount(): Int {
            return orderList.size
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun bind(order: Snack) {
                val snackTitle = itemView.findViewById<TextView>(R.id.snack_title)
                val snackPrice = itemView.findViewById<TextView>(R.id.snack_price)
                val snackIcon = itemView.findViewById<ImageView>(R.id.icon_cell)
                val requiredSnackTime = itemView.findViewById<Button>(R.id.snack_time_required)
                snackIcon.setImageResource(order.icon)
                requiredSnackTime.setText(order.requiredTime)
                snackTitle.setText(order.name)
                snackPrice.setText(resources.getString(R.string.detailed_price, order.price))

                val container = itemView as RelativeLayout
                container.setOnClickListener {
                    val i = Intent(this@MainActivity, DetailedSnackActivity::class.java)
                        .putExtra("id", order.id)
                        .putExtra("price", order.price)
                        .putExtra("name", order.name)
                    startActivity(i)
                }

            }

        }


    }


}