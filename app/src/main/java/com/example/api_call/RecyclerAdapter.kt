package com.example.api_call

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api_call.networking.Article
import com.squareup.picasso.Picasso

class RecyclerAdapter (private val dataSet: List<Article>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        lateinit var  userId: TextView
        lateinit var  title: TextView
        lateinit var image : ImageView
        init {
            // Define click listener for the ViewHolder's View.
//            userId = view.findViewById(R.id.userId)
            title = view.findViewById(R.id.titleId)
            image = view.findViewById(R.id.imageId)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.userId.text = dataSet[position].id.toString()
        viewHolder.title.text = dataSet[position].title
        Picasso.get().load(dataSet[position].urlToImage).into(viewHolder.image)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
