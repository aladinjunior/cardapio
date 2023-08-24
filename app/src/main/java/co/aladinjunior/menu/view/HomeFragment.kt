package co.aladinjunior.menu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.R
import co.aladinjunior.menu.model.Snack

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val snacks = createSnack()



        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        val adapter = Adapter(snacks, requireContext())
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter
        return view
    }

    private fun createSnack() : List<Snack>{

        return listOf(
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

    }





//    private inner class Adapter(
//        private val snacks: List<Snack>
//    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
//            val view = layoutInflater.inflate(R.layout.snack_item, parent, false)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
//            val currentItem = snacks[position]
//            holder.bind(currentItem)
//        }
//
//        override fun getItemCount(): Int {
//            return snacks.size
//        }
//
//        private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            fun bind(snack: Snack) {
////                val snackTitle = itemView.findViewById<TextView>(R.id.snack_title)
////                val snackPrice = itemView.findViewById<TextView>(R.id.snack_price)
////                val snackIcon = itemView.findViewById<ImageView>(R.id.icon_cell)
////                val requiredSnackTime = itemView.findViewById<Button>(R.id.snack_time_required)
////                snackIcon.setImageResource(snack.icon)
////                requiredSnackTime.setText(snack.requiredTime)
////                snackTitle.setText(snack.name)
////                snackPrice.setText(resources.getString(R.string.detailed_price, snack.price))
////
////                val container = itemView as RelativeLayout
////                container.setOnClickListener {
////                    val i = Intent(activity, DetailedSnackActivity::class.java)
////                        .putExtra("id", snack.id)
////                        .putExtra("price", snack.price)
////                        .putExtra("name", snack.name)
////                    activity?.startActivity(i)
////                        ?: throw IllegalStateException("A atividade não pode ser nula!")
////
////                }
//            }
//
//        }
//
//    }
}


