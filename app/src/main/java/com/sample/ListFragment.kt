package com.sample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListFragment : Fragment() {
    lateinit var recyclerListView: RecyclerView
    lateinit var listener: ListFragmentListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerListView = view.findViewById(R.id.recyclerList)
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            listener=context as ListFragmentListener
        }
    }

    interface ListFragmentListener {
        fun clickOnList(relatedTopic: RelatedTopic)
    }


    inner class ListAdapter(val list:List<RelatedTopic>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
        val filterList:List<RelatedTopic>
        init {
            filterList=list
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ListViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return filterList.size
        }


        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }



        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView
            init {
                textView=itemView.findViewById(R.id.list_item_text)
                textView.apply {
                    this.setOnClickListener {
                        listener.clickOnList(filterList[adapterPosition])
                    }
                }
            }


        }

    }


     fun filter(models:List<RelatedTopic>, query:String):List<RelatedTopic> {
        val query = query.toLowerCase()
        val searchString = query
        val filteredModelList = mutableListOf<RelatedTopic>()
        for (model in models)
        {
            val text = model.Text.toLowerCase()
            if (text.contains(query))
            {
                filteredModelList.add(model)
            }
        }
        val myRecAdapter = ListAdapter(filteredModelList)
         recyclerListView.setLayoutManager(LinearLayoutManager(this@ListFragment.activity))
         recyclerListView.setAdapter(myRecAdapter)
        myRecAdapter.notifyDataSetChanged()
        return filteredModelList
    }

}