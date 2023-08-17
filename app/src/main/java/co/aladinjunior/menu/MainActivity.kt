package co.aladinjunior.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.model.Snack

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val orderList = mutableListOf<Snack>()

        for (i in 1 until 11) {
            val hambuguerTitle = resources.getString(R.string.hamburguer1_title, i)
            val x = Snack(id = 1, name = hambuguerTitle, price = R.string.hamburguer1_price)
            orderList.add(x)
        }

        val adapter = Adapter(orderList)
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
                snackPrice.setText(order.price)

            }

        }


    }


}