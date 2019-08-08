package com.robertlevonyan.components.kex

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.*

fun Spinner.create(@LayoutRes itemLayout: Int, @IdRes textViewId: Int, items: Array<String>,
                   onItemSelected: (String, Int) -> Unit = { _, _ -> }) {
    val aAdapter = ArrayAdapter<String>(context, itemLayout, textViewId, items)
    adapter = aAdapter
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelected(items[position], position)
        }
    }
}

fun Spinner.create(@LayoutRes itemLayout: Int, @IdRes textViewId: Int, items: MutableList<String>,
                   onItemSelected: (String, Int) -> Unit = { _, _ -> }) {
    val aAdapter = ArrayAdapter<String>(context, itemLayout, textViewId, items)
    adapter = aAdapter
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelected(items[position], position)
        }
    }
}

fun AutoCompleteTextView.create(@LayoutRes itemLayout: Int, @IdRes textViewId: Int, items: Array<String>,
                                onItemSelected: (String, Int) -> Unit = { _, _ -> }) {
    val adapter = ArrayAdapter<String>(context, itemLayout, textViewId, items)
    setAdapter(adapter)
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelected(items[position], position)
        }
    }
}

fun AutoCompleteTextView.create(@LayoutRes itemLayout: Int, @IdRes textViewId: Int, items: MutableList<String>,
                                onItemSelected: (String, Int) -> Unit = { _, _ -> }) {
    val adapter = ArrayAdapter<String>(context, itemLayout, textViewId, items)
    setAdapter(adapter)
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelected(items[position], position)
        }
    }
}

fun <T> ListView.create(itemLayout: Int, items: Array<T>, creator: View.(T, Int) -> Unit,
                        itemClick: (T, Int) -> Unit = { _, _ -> },
                        itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
    val adapter = ListAdapter(itemLayout, items, creator, itemClick, itemLongClick)
    setAdapter(adapter)
}

fun <T> ListView.create(itemLayout: Int, items: MutableList<T>, creator: View.(T, Int) -> Unit,
                        itemClick: (T, Int) -> Unit = { _, _ -> },
                        itemLongClick: (T, Int) -> Unit = { _, _ -> }) {
    val adapter = ListAdapter(itemLayout, items, creator, itemClick, itemLongClick)
    setAdapter(adapter)
}

fun <T> RecyclerView.create(itemLayout: Int, items: Array<T>, layoutMgr: RecyclerView.LayoutManager,
                                                         creator: View.(T, Int) -> Unit,
                                                         itemClick: (T, Int) -> Unit = { _, _ -> },
                                                         itemLongClick: (T, Int) -> Unit = { _, _ -> },
                                                         onScrollTop: () -> Unit = {},
                                                         onScrollBottom: () -> Unit = {}) {
    adapter = RecyclerAdapter(itemLayout, items, creator, itemClick, itemLongClick)
    layoutManager = layoutMgr
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            when {
                dy < 0 -> onScrollTop()
                dy > 0 -> onScrollBottom()
            }
        }
    })
}

fun <T> RecyclerView.create(itemLayout: Int, items: MutableList<T>, layoutMgr: RecyclerView.LayoutManager,
                                                         creator: View.(T, Int) -> Unit,
                                                         itemClick: (T, Int) -> Unit = { _, _ -> },
                                                         itemLongClick: (T, Int) -> Unit = { _, _ -> },
                                                         onScrollTop: () -> Unit = {},
                                                         onScrollBottom: () -> Unit = {}) {
    adapter = RecyclerAdapter(itemLayout, items, creator, itemClick, itemLongClick)
    layoutManager = layoutMgr
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            when {
                dy < 0 -> onScrollTop()
                dy > 0 -> onScrollBottom()
            }
        }
    })
}

fun <T> RecyclerView.createTypedList(itemLayout: Map<Int, Int>, items: Array<T>,
                                                                  layoutMgr: RecyclerView.LayoutManager,
                                                                  itemTypes: (position: Int) -> Int,
                                                                  creator: View.(T, Int, Int) -> Unit,
                                                                  itemClick: (T, Int) -> Unit = { _, _ -> },
                                                                  itemLongClick: (T, Int) -> Unit = { _, _ -> },
                                                                  onScrollTop: () -> Unit = {},
                                                                  onScrollBottom: () -> Unit = {}) {
    adapter = TypedRecyclerAdapter(itemLayout, items, itemTypes, creator, itemClick, itemLongClick)
    layoutManager = layoutMgr
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            when {
                dy < 0 -> onScrollTop()
                dy > 0 -> onScrollBottom()
            }
        }
    })
}

fun <T> RecyclerView.createTypedList(itemLayout: Map<Int, Int>, items: MutableList<T>,
                                                                  layoutMgr: RecyclerView.LayoutManager,
                                                                  itemTypes: (position: Int) -> Int,
                                                                  creator: View.(T, Int, Int) -> Unit,
                                                                  itemClick: (T, Int) -> Unit = { _, _ -> },
                                                                  itemLongClick: (T, Int) -> Unit = { _, _ -> },
                                                                  onScrollTop: () -> Unit = {},
                                                                  onScrollBottom: () -> Unit = {}) {
    adapter = TypedRecyclerAdapter(itemLayout, items, itemTypes, creator, itemClick, itemLongClick)
    layoutManager = layoutMgr
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            when {
                dy < 0 -> onScrollTop()
                dy > 0 -> onScrollBottom()
            }
        }
    })
}

@Suppress("UNCHECKED_CAST")
fun <T> RecyclerView.addItem(item: T): T? {
    return when (adapter) {
        is RecyclerAdapter<*> -> {
            (adapter as RecyclerAdapter<T>).addItem(item)
            item
        }
        is TypedRecyclerAdapter<*> -> {
            (adapter as TypedRecyclerAdapter<T>).addItem(item)
            item
        }
        else -> null
    }
}

@Suppress("UNCHECKED_CAST")
fun <T> RecyclerView.updateItem(item: T, position: Int): T? {
    return when (adapter) {
        is RecyclerAdapter<*> -> {
            (adapter as RecyclerAdapter<T>).updateItem(item, position)
            item
        }
        is TypedRecyclerAdapter<*> -> {
            (adapter as TypedRecyclerAdapter<T>).updateItem(item, position)
            item
        }
        else -> null
    }
}

@Suppress("UNCHECKED_CAST")
fun <T> RecyclerView.removeItem(position: Int): T? = when (adapter) {
    is RecyclerAdapter<*> -> {
        (adapter as RecyclerAdapter<T>).removeItem(position)
    }
    is TypedRecyclerAdapter<*> -> {
        (adapter as TypedRecyclerAdapter<T>).removeItem(position)
    }
    else -> null
}

fun ViewPager.createFragmentPager(fragments: Array<Fragment>, supportFragmentManager: FragmentManager) {
    val pAdapter = PagerAdapter(supportFragmentManager)
    pAdapter.fragmentsArray = fragments

    adapter = pAdapter
}

fun ViewPager.createFragmentPager(fragments: MutableList<Fragment>, supportFragmentManager: FragmentManager) {
    val pAdapter = PagerAdapter(supportFragmentManager)
    pAdapter.fragmentsList = ArrayList(fragments)

    adapter = pAdapter
}

fun ViewPager.onPageScrollStateChanged(onPageScrollStateChanged: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
        }

    })
}

fun ViewPager.onPageScrolled(onPageScrolled: (Int, Float, Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
        }

    })
}

fun ViewPager.onPageSelected(onPageSelected: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            onPageSelected(position)
        }

    })
}