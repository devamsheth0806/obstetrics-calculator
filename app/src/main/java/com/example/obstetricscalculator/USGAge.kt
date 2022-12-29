package com.example.obstetricscalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.obstetricscalculator.databinding.FragmentUsgAgeBinding
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

class USGAge : Fragment() {
    private var binding: FragmentUsgAgeBinding? = null
    private var calculateButton: Button? = null
    private var usgAgeView: TextView? = null
    private var usgDatePicker: DatePicker? = null
    private var usgDaysAge: EditText? = null
    private var usgWeeksAge: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        val inflate = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.fragment_usg_age,
            viewGroup,
            false
        )
        var fragmentUsgAgeBinding: FragmentUsgAgeBinding? = inflate as FragmentUsgAgeBinding
        binding = fragmentUsgAgeBinding
        if (fragmentUsgAgeBinding == null) {
            fragmentUsgAgeBinding = null
        }
        return fragmentUsgAgeBinding!!.root
    }

    // androidx.fragment.app.Fragment
    override fun onViewCreated(view: View, bundle: Bundle?) {
        super.onViewCreated(view, bundle)
        var fragmentUsgAgeBinding = binding
        var button: Button? = null
        val datePicker = fragmentUsgAgeBinding!!.editUSGDate
        usgDatePicker = datePicker
        var fragmentUsgAgeBinding2 = binding
        val editText = fragmentUsgAgeBinding2!!.editWeeksAge
        usgWeeksAge = editText
        var fragmentUsgAgeBinding3 = binding
        val editText2 = fragmentUsgAgeBinding3!!.editDaysAge
        usgDaysAge = editText2
        var fragmentUsgAgeBinding4 = binding
        val textView = fragmentUsgAgeBinding4!!.usgAgeResultView
        usgAgeView = textView
        var fragmentUsgAgeBinding5 = binding
        val button2 = fragmentUsgAgeBinding5!!.calculateUsgButton
        calculateButton = button2
        button = button2
        button!!.setOnClickListener { view2 ->
            getUSGAge(view2)
        }
    }

    fun calculateUsgAge(): Long {
        var datePicker = usgDatePicker
        var editText: EditText? = null
        if (datePicker == null) {
            datePicker = null
        }
        val month = datePicker!!.month + 1
        var datePicker2 = usgDatePicker
        if (datePicker2 == null) {
            datePicker2 = null
        }
        val dayOfMonth = datePicker2!!.dayOfMonth
        var datePicker3 = usgDatePicker
        if (datePicker3 == null) {
            datePicker3 = null
        }
        val year = datePicker3!!.year
        return try {
            var editText2 = usgWeeksAge
            if (editText2 == null) {
                editText2 = null
            }
            val parseInt = editText2!!.text.toString().toInt()
            try {
                val editText3 = usgDaysAge
                if (editText3 == null) {
                } else {
                    editText = editText3
                }
                val parseInt2 = parseInt * 7 + editText!!.text.toString().toInt()
                println(parseInt2)
                val now = LocalDateTime.now()
                Duration.between(
                    LocalDateTime.of(
                        year,
                        month,
                        dayOfMonth,
                        now.hour,
                        now.minute,
                        now.second
                    ).minusDays(parseInt2.toLong()), now
                ).toDays()
            } catch (unused: Exception) {
                throw Exception("Please Enter USG Days Age")
            }
        } catch (unused2: Exception) {
            throw Exception("Please Enter USG Weeks Age")
        }
    }


    fun getUSGAge(view: View?) {
        try {
            val calculateUsgAge = calculateUsgAge()
            val j = calculateUsgAge / 7
            val j2 = calculateUsgAge % 7
            var textView = usgAgeView
            if (textView == null) {
                textView = null
            }
            val format = String.format(
                "%s Weeks and %s Days",
                *Arrays.copyOf(
                    arrayOf<Any>(
                        java.lang.Long.valueOf(j),
                        java.lang.Long.valueOf(j2)
                    ), 2
                )
            )
            textView!!.text = format
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
    }

}