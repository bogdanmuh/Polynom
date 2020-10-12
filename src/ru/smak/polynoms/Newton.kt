package ru.smak.polynoms

class Newton (dots:MutableMap<Double,Double>):Polynom()
{
    private val divDiff= mutableMapOf<Pair<Int,Int>,Double>()
    private var fundamental = Polynom(doubleArrayOf(1.0))
    private var base = Polynom(doubleArrayOf(5.0))
    var dots1 : ArrayList<Double> = arrayListOf()

    init
    {
        var i=0
        dots.forEach{x,y->
            divDiff.putIfAbsent(Pair(i,i),y)
            i++
            build(x,y)
        }

    }
    constructor():this(mutableMapOf())

    private fun build (x:Double,y:Double)
    {
        dots1.add(x)

            //считает фундаментальный полином
             fundamental = funda(x)
            //считает разность
            val div = Div(0,dots1.size-1)
            base += fundamental*div
            //val pair = divDiff[Pair(0,0)]
        //fundamental=divDiff[Pair(1,1)]
    }
    private fun funda(k:Double ):Polynom
    {
        if (!(dots1.size==1)) {

            val p1 = Polynom(doubleArrayOf(-k, 1.0))
            return fundamental * p1
        }
        else
        {

            return fundamental

        }
    }
    private fun Div(first:Int,last:Int): Double
    {

            if (!divDiff.containsKey(Pair(first, last)))
            {
                if ((last-first>1)) {

                    val x = Div(first + 1, last)

                    val y = Div(first, last - 1)

                    divDiff.putIfAbsent(Pair(first,last ),(x!! - y!!) / (last - first))
                    return (x!! - y!!) / (last - first)
                }
                else {
                    if ((last-first==1)) {


                        val y = divDiff[Pair(first, first)]

                        val x = divDiff[Pair(last, last)]

                        return (x!! - y!!) / (last - first)
                    }
                    else{
                        return divDiff[Pair(last, last)]!!
                    }
                }
            } else {
                return divDiff[Pair(first, last)]!!
            }
        }
    }





