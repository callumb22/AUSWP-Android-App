package uk.ac.aber.dcs.cs39440.auswpandroidapp.ui.tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uk.ac.aber.dcs.cs39440.auswpandroidapp.R
import uk.ac.aber.dcs.cs39440.auswpandroidapp.databinding.FragmentAddWorkoutBinding


class addWorkoutFragment : Fragment(), View.OnClickListener {




    private lateinit var addWorkoutFragmentBinding: FragmentAddWorkoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val parent = requireActivity() as ToggleState
        parent.setNavigationDrawer(false)
        backbuttonpress()
        addWorkoutFragmentBinding = FragmentAddWorkoutBinding.inflate(inflater,container,false)



        val botNav: BottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_view)
        botNav.isVisible = false

        addWorkoutFragmentBinding.add.setOnClickListener(this)



        return addWorkoutFragmentBinding.root
    }

    private fun backbuttonpress(){
        val callback: OnBackPressedCallback =
            object: OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    findNavController().navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        val parent = requireActivity() as ToggleState
        parent.setNavigationDrawer(false)
    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.add -> {
                insertWorkout()
            }
            else -> {

            }
        }
    }

    private fun insertWorkout(){
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        val botNav: BottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_view)
        botNav.isVisible = true



        super.onDestroyView()
    }

    }
