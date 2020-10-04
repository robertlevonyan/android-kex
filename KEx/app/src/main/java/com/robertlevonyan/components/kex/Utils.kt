package com.robertlevonyan.components.kex

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListAdapter<out T> : BaseAdapter {
    @LayoutRes
    private val itemLayout: Int
    private var items: Array<T>? = null
    private var itemsList: MutableList<T>? = null
    private val creator: View.(T, Int) -> Unit
    private val itemClick: (T, Int) -> Unit
    private val itemLongClick: (T, Int) -> Unit

    constructor(itemLayout: Int, items: Array<T>, creator: View.(T, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.itemLayout = itemLayout
        this.items = items
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    constructor(itemLayout: Int, items: MutableList<T>, creator: View.(T, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.itemLayout = itemLayout
        this.itemsList = items
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = if (items == null) {
            itemsList!![position]
        } else {
            items!![position]
        }
        val view = convertView ?: parent!! inflate itemLayout
        view.setOnClickListener { itemClick(item, position) }
        view.setOnLongClickListener { itemLongClick(item, position);true }
        creator(view, item, position)

        return view
    }

    override fun getItem(position: Int): T {
        return if (items == null) {
            itemsList!![position]
        } else {
            items!![position]
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return if (items == null) {
            itemsList!!.size
        } else {
            items!!.size
        }
    }
}

class RecyclerAdapter<T> : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    @LayoutRes
    private val itemLayout: Int
    private var items: Array<T>? = null
    private var itemsList: MutableList<T>? = null
    private val creator: View.(T, Int) -> Unit
    private val itemClick: (T, Int) -> Unit
    private val itemLongClick: (T, Int) -> Unit

    constructor(itemLayout: Int, items: Array<T>,
                creator: View.(T, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.itemLayout = itemLayout
        this.items = items
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    constructor(itemLayout: Int, items: MutableList<T>,
                creator: View.(T, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.itemLayout = itemLayout
        this.itemsList = items
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent inflate itemLayout)

    override fun getItemCount() = if (items == null) {
        itemsList!!.size
    } else {
        items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = if (items == null) {
            itemsList!![position]
        } else {
            items!![position]
        }

        holder.itemView.setOnClickListener { itemClick(item, position) }
        holder.itemView.setOnLongClickListener { itemLongClick(item, position);true }
        creator(holder.itemView!!, item, position)
    }

    fun getItem(position: Int): T {
        items?.let {
            return it[position]
        } ?: itemsList?.let {
            return it[position]
        }
        ?: throw NullPointerException("Your list is empty")
    }

    fun addItem(item: T, position: Int = 0) {
        if (itemsList == null) {
            throw NullPointerException("Your data is Array, change to List to add items dynamically")
        }

        itemsList?.add(position, item)
        notifyItemInserted(position)
    }

    fun updateItem(item: T, position: Int) = if (itemsList == null) {
        items?.set(position, item)
        notifyItemChanged(position)
    } else {
        itemsList?.set(position, item)
        notifyItemChanged(position)
    }

    fun removeItem(position: Int): T {
        if (itemsList == null) {
            throw NullPointerException("Your data is Array, change to List to remove items dynamically")
        }

        if (position < 0) {
            throw IllegalStateException("Position must be >= 0")
        }

        if (position >= itemsList?.size!!) {
            throw IllegalStateException("Position is too big")
        }

        val item = itemsList?.removeAt(position)
        notifyItemRemoved(position)

        return item!!
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}

class TypedRecyclerAdapter<T> : RecyclerView.Adapter<TypedRecyclerAdapter.TypedViewHolder> {
    private val layoutForType: Map<Int, Int>
    private var items: Array<T>? = null
    private var itemsList: MutableList<T>? = null
    private var itemTypes: (position: Int) -> Int
    private val creator: View.(T, Int, Int) -> Unit
    private val itemClick: (T, Int) -> Unit
    private val itemLongClick: (T, Int) -> Unit

    private var currentType = -1

    constructor(layoutForType: Map<Int, Int>, items: Array<T>,
                itemTypes: (position: Int) -> Int,
                creator: View.(T, Int, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.layoutForType = layoutForType
        this.items = items
        this.itemTypes = itemTypes
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    constructor(layoutForType: Map<Int, Int>, items: MutableList<T>,
                itemTypes: (position: Int) -> Int,
                creator: View.(T, Int, Int) -> Unit,
                itemClick: (T, Int) -> Unit = { _, _ -> },
                itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
        this.layoutForType = layoutForType
        this.itemsList = items
        this.itemTypes = itemTypes
        this.creator = creator
        this.itemClick = itemClick
        this.itemLongClick = itemLongClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypedRecyclerAdapter.TypedViewHolder {
        var v: View? = null
        for (type in layoutForType.keys) {
            val layout = layoutForType[type]
            if (type == viewType) {
                currentType = type
                v = parent inflate layout!!
                break
            }
        }
        return TypedViewHolder(v)
    }

    override fun getItemCount(): Int {
        return if (items == null) {
            itemsList!!.size
        } else {
            items!!.size
        }
    }

    override fun onBindViewHolder(holder: TypedRecyclerAdapter.TypedViewHolder, position: Int) {
        val item = if (items == null) {
            itemsList!![position]
        } else {
            items!![position]
        }

        holder.itemView.setOnClickListener { itemClick(item, position) }
        holder.itemView.setOnLongClickListener { itemLongClick(item, position);true }

        creator(holder.itemView!!, item, position, currentType)
    }

    override fun getItemViewType(position: Int): Int {
        return itemTypes(position)
    }

    fun addItem(item: T) {
        if (itemsList == null) {
            throw NullPointerException("Your data is Array, change to List to add items dynamically")
        }

        itemsList?.add(item)
        notifyItemInserted(itemsList?.size!!)
    }

    fun updateItem(item: T, position: Int) = if (itemsList == null) {
        items?.set(position, item)
        notifyItemChanged(position)
    } else {
        itemsList?.set(position, item)
        notifyItemChanged(position)
    }

    fun removeItem(position: Int): T {
        if (itemsList == null) {
            throw NullPointerException("Your data is Array, change to List to remove items dynamically")
        }

        if (position < 0) {
            throw IllegalStateException("Position must be >= 0")
        }

        if (position >= itemsList?.size!!) {
            throw IllegalStateException("Position is too big")
        }

        val item = itemsList?.removeAt(position)
        notifyItemRemoved(position)

        return item!!
    }

    class TypedViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}

class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var fragmentsList = ArrayList<Fragment>()
    var fragmentsArray: Array<Fragment>? = null

    override fun getItem(position: Int): Fragment {
        return if (fragmentsArray == null) {
            fragmentsList[position]
        } else {
            fragmentsArray!![position]
        }
    }

    override fun getCount(): Int {
        return if (fragmentsArray == null) {
            fragmentsList.size
        } else {
            fragmentsArray?.size!!
        }
    }
}