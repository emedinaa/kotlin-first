package com.emedinaa.marvelapp.step4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.emedinaa.marvelapp.R
import com.emedinaa.marvelapp.adapter.RecyclerClickListener
import com.emedinaa.marvelapp.adapter.RecyclerTouchListener
import com.emedinaa.marvelapp.step3.HeroEntity
import com.emedinaa.marvelapp.step3.HeroHAdapter
import kotlinx.android.synthetic.main.fragment_gallery.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GalleryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GalleryDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private val data= mutableListOf<HeroEntity>()

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
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        data.add(HeroEntity("IronMan",R.drawable.iron_man_box,1))
        data.add(HeroEntity("Scarlet Witch",R.drawable.scarlet_witch_box,0))
        data.add(HeroEntity("Doctor Strange",R.drawable.doctor_strange_box,1))
        data.add(HeroEntity("Hulk",R.drawable.hulk_box,1))
        data.add(HeroEntity("Gamora",R.drawable.gamora_box,0))
        data.add(HeroEntity("Black Widow",R.drawable.black_widow_box,0))

        recyclerViewDialog.layoutManager= GridLayoutManager(context,3)
        recyclerViewDialog.adapter= GalleryAdapter( data.toList())

        context?.let {
            recyclerViewDialog.addOnItemTouchListener(RecyclerTouchListener(it,
                recyclerViewDialog,object :RecyclerClickListener{
                    override fun onClick(view: View, position: Int) {
                        listener?.onSelectedItem(position,data[position].photo)
                        dismiss()
                    }

                    override fun onLongClick(view: View, position: Int) {

                    }
                }))
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onSelectedItem(position:Int,resource:Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GalleryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GalleryDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class GalleryAdapter(private var heroList:List<HeroEntity>): RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GalleryAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_gallery, parent, false)
            return GalleryAdapter.ViewHolder(view)
        }

        override fun onBindViewHolder(vh: GalleryAdapter.ViewHolder, position: Int) {
            val hero= heroList[position]

            vh.imageView.setImageResource(hero.photo)
        }

        override fun getItemCount(): Int {
            return heroList.size
        }

        fun getItem(position: Int): HeroEntity {
            return heroList[position]
        }


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val imageView: ImageView = view.findViewById(R.id.imageView)
        }
    }
}
