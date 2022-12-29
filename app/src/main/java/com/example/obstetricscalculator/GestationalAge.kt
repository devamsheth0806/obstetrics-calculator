package com.example.obstetricscalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.obstetricscalculator.databinding.FragmentGestationalAgeBinding
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class GestationalAge : Fragment() {
    private var ageView: TextView? = null
    private var binding: FragmentGestationalAgeBinding? = null
    private var button: Button? = null
    private var datePicker: DatePicker? = null
    private var edd: LocalDate? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {
        val inflate = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.fragment_gestational_age,
            viewGroup,
            false
        )
        val fragmentGestationalAgeBinding: FragmentGestationalAgeBinding =
            inflate as FragmentGestationalAgeBinding
        binding = fragmentGestationalAgeBinding
        return fragmentGestationalAgeBinding.root
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        super.onViewCreated(view, bundle)
        var fragmentGestationalAgeBinding = binding
        val button2 = fragmentGestationalAgeBinding!!.buttonCalculateGestational
        this.button = button2
        val datePicker = fragmentGestationalAgeBinding!!.editLMPDate
        this.datePicker = datePicker
        val textView = fragmentGestationalAgeBinding!!.ageView
        this.ageView = textView
        this.button!!.setOnClickListener(View.OnClickListener {
            fun onClick(p0: View?) {
                getGestationalAge()
            }
        })
    }

    private fun calculateGestationalAge(): Long {
        var datePicker = datePicker
        var datePicker2: DatePicker? = null
        val month = datePicker!!.month + 1
        var datePicker3 = this.datePicker
        val dayOfMonth = datePicker3!!.dayOfMonth
        val datePicker4 = this.datePicker
        datePicker2 = datePicker4
        val year = datePicker2!!.year
        val now = LocalDateTime.now()
        val of = LocalDateTime.of(year, month, dayOfMonth, now.hour, now.minute, now.second)
        val between = Duration.between(of, now)
        val plusDays = of.plusDays(280L)
        val of2 = LocalDate.of(plusDays.year, plusDays.month, plusDays.dayOfMonth)
        edd = of2
        return between.toDays()
    }

    fun getGestationalAge() {
        val calculateGestationalAge = calculateGestationalAge()
        val j = calculateGestationalAge / 7
        val j2 = calculateGestationalAge % 7
        var textView = ageView
        var localDate: LocalDate? = null

        val objArr = arrayOfNulls<Any>(3)
        objArr[0] = java.lang.Long.valueOf(j)
        objArr[1] = java.lang.Long.valueOf(j2)
        val localDate2 = edd
        localDate = localDate2
        objArr[2] = localDate!!.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
        val format = String.format(
            "%s Weeks and %s Days\n Estimated Delivery Date is \n %s",
            *objArr
        )
        textView!!.text = format
    }

}