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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val orderList = mutableListOf<CellOrder>()

        orderList.add(
            CellOrder(
                snackTitle = R.string.hamburguer1_title ,
                snackPrice = R.string.hamburguer1_price)
        )
        orderList.add(
            CellOrder(
                snackTitle = R.string.hamburguer2_title,
                snackPrice = R.string.hamburguer2_price
            )
        )

        val adapter = Adapter(orderList)
        val rv = findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

    }

    private inner class Adapter(private val orderList: List<CellOrder>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.order_cell, parent, false)
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
            fun bind(order: CellOrder) {
                val snackTitle = itemView.findViewById<TextView>(R.id.snack_title)
                val snackPrice = itemView.findViewById<TextView>(R.id.snack_price)
                val snackIcon = itemView.findViewById<ImageView>(R.id.icon_cell)
                val requiredSnackTime = itemView.findViewById<Button>(R.id.snack_time_required)
                snackIcon.setImageResource(order.orderIcon)
                requiredSnackTime.setText(order.snackRequiredTime)
                snackTitle.setText(order.snackTitle)
                snackPrice.setText(order.snackPrice)

            }

        }


    }



}