package com.example.sportexfield.lib

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.sportexfield.R
import com.example.sportexfield.databinding.PartFootballFieldBinding
import com.example.sportexfield.dp
import com.example.sportexfield.logger
import com.example.sportexfield.model.PositionDto
import com.example.sportexfield.model.SchemaDto

@SuppressLint("ResourceType")
class FootballField(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var _binding: PartFootballFieldBinding? = null
    val binding get() = _binding ?: error("field binding error")

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : this(context, attrs, defStyleAttr, 0)

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(
        context: Context
    ) : this(context, null)


    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.part_football_field, this, true)
        _binding = PartFootballFieldBinding.bind(this)
        logger("$width $height")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        logger("$w $h ${binding.field.width}")
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        logger("draw")
        super.onDraw(canvas)
    }

    fun setScheme(schema: SchemaDto) = with(binding) {
        val constraint = root as ConstraintLayout
        logger("${constraint.layoutParams.width}")
        schema.positions.forEach {
            val view = View(context)
            view.setBackgroundColor(Color.BLACK)
            view.id = View.generateViewId()
            val size = 48.dp
            view.layoutParams = LayoutParams(size, size)
            val xy = findXY(it)
            constraint.addView(view)
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraint)
            constraintSet.connect(
                view.id, ConstraintSet.TOP, xy.first, ConstraintSet.TOP, -size / 2
            )
            constraintSet.connect(
                view.id, ConstraintSet.START, xy.second, ConstraintSet.START, -size / 2
            )
            constraintSet.applyTo(constraint)
        }
    }

    private fun findXY(
        position: PositionDto
    ): Pair<Int, Int> = with(binding) {
        val line = when (position.line) {
            1 -> line1
            2 -> line2
            3 -> line3
            4 -> line4
            5 -> line5
            6 -> line6
            7 -> line7
            8 -> line8
            9 -> line9
            else -> line1
        }
        val col = when (position.col) {
            1 -> col1
            2 -> col2
            3 -> col3
            4 -> col4
            5 -> col5
            6 -> col6
            7 -> col7
            8 -> col8
            9 -> col9
            else -> col1
        }
        return Pair(line.id, col.id)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        logger("onLayout")
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        logger("measure")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}