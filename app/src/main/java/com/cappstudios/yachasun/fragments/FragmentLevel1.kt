package com.cappstudios.yachasun.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cappstudios.yachasun.R
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLevel1.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLevel1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var textHola: TextView? = null
    private var rvlevel1: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view1 = inflater.inflate(R.layout.fragment_level_1, container, false)
//
////        val txt1 = view1.findViewById(R.id.textViewHola)
//
//        return view1
        val rootView: View = inflater.inflate(R.layout.fragment_level_1, container, false)
//        textHola = rootView.findViewById<View>(R.id.textViewHola) as TextView
        rvlevel1 = rootView.findViewById<View>(R.id.rvlevel1) as RecyclerView

//        textHola!!.setText("Hola Desde Fragement!!")
        val data : MutableList<BookObject> = ArrayList()
        for (i:Int in 1..5)
            data.add(BookObject(title = "Libro $i"))
        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
        val adapter = BookAdapter(data)
        rvlevel1!!.layoutManager = layoutManager
        rvlevel1!!.setHasFixedSize(true)
        rvlevel1!!.adapter = adapter
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLevelOne.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLevel1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
