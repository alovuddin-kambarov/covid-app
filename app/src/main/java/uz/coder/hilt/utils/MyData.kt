package uz.coder.hilt.utils

import uz.coder.hilt.R
import uz.coder.hilt.models.GlobalNews
import uz.coder.hilt.models.Prevention
import uz.coder.hilt.models.SpinnerData

object MyData {

    fun getPreventionData(): ArrayList<Prevention> {
        val arrayList = ArrayList<Prevention>()

        arrayList.add(Prevention(R.drawable.ic_user_musk, "Use musk", "Lorem ipsum dolor sit amet"))
        arrayList.add(
            Prevention(
                R.drawable.ic_wash_hand,
                "Wash your hand",
                "Lorem ipsum dolor sit amet"
            )
        )
        arrayList.add(
            Prevention(
                R.drawable.ic_cloase_contact,
                "Avoid close contact",
                "Lorem ipsum dolor sit amet"
            )
        )

        arrayList.add(Prevention(R.drawable.ic_user_musk, "Use musk", "Lorem ipsum dolor sit amet"))
        arrayList.add(
            Prevention(
                R.drawable.ic_wash_hand,
                "Wash your hand",
                "Lorem ipsum dolor sit amet"
            )
        )
        arrayList.add(
            Prevention(
                R.drawable.ic_cloase_contact,
                "Avoid close contact",
                "Lorem ipsum dolor sit amet"
            )
        )

        arrayList.add(Prevention(R.drawable.ic_user_musk, "Use musk", "Lorem ipsum dolor sit amet"))
        arrayList.add(
            Prevention(
                R.drawable.ic_wash_hand,
                "Wash your hand",
                "Lorem ipsum dolor sit amet"
            )
        )
        arrayList.add(
            Prevention(
                R.drawable.ic_cloase_contact,
                "Avoid close contact",
                "Lorem ipsum dolor sit amet"
            )
        )

        return arrayList
    }

    fun getCountryData(): ArrayList<SpinnerData> {

        val list = ArrayList<SpinnerData>()
        list.add(SpinnerData("UZB","https://nbu.uz/local/templates/nbu/images/flags/uz.png"))
        list.add(SpinnerData("RUS","https://nbu.uz/local/templates/nbu/images/flags/ru.png"))
        list.add(SpinnerData("TRY","https://nbu.uz/local/templates/nbu/images/flags/TRY.png"))
        list.add(SpinnerData("USD","https://nbu.uz/local/templates/nbu/images/flags/USD.png"))

        return list
    }

    fun getCountryNews(): ArrayList<GlobalNews> {

        val arrayList = ArrayList<GlobalNews>()
        arrayList.add(
            GlobalNews(
                "https://d2v9ipibika81v.cloudfront.net/uploads/sites/78/06-11-1140x684.jpg",
                "Uzbekistan news",
                "News & Events - U.S. Embassy in Uzbekistan\n" +
                        "Images may be subject to copyright. Learn More"
            )
        )

        arrayList.add(
            GlobalNews(
                "https://eurasianet.org/sites/default/files/styles/article/public/2020-07/Fergana%20reg%20gov%20106743632_1104918726556880_7276706795369656851_o.jpg?itok=7Z-cxtDI",
                "Uzbekistan news",
                "Uzbekistan: After a positive start, coronavirus driving health system to precipice"
            )
        )
        arrayList.add(
            GlobalNews(
                "https://d2v9ipibika81v.cloudfront.net/uploads/sites/78/06-11-1140x684.jpg",
                "Uzbekistan news",
                "Uzbekistan. The donation brings the total number of COVID-19 vaccines that the United States has donated to Uzbekistan to 7.6 million. Diseases know no borders. The vaccines ..."
            )
        )


        return arrayList
    }

    fun getGlobalNews(): ArrayList<GlobalNews> {

        val arrayList = ArrayList<GlobalNews>()
        arrayList.add(
            GlobalNews(
                "https://i1.wp.com/media.globalnews.ca/videostatic/news/fuye8x2fms-qdzgqbp788/CONTAGIOUS_THUJMB.jpg?w=1040#038;quality=70&strip=all",
                "Global news",
                "COVID-19 rapid tests an imperfect and necessary tool in potential sixth wave, experts say"
            )
        )
        arrayList.add(
            GlobalNews(
                "https://cdn.24.co.za/files/Cms/General/d/957/25ceb191c8834fa59c97c2656ac4fab8.jpg",
                "Global news",
                "China's President Xi Jinping has praised the country's \"tested\" zero-Covid strategy, even as Shang"
            )
        )
        arrayList.add(
            GlobalNews(
                "https://vcdn-english.vnecdn.net/2022/04/08/mamnondihoc1158917859675941649-8657-9434-1649415138_1200x0.jpg",
                "Global news",
                "COVID-19 rapid tests an imperfect and necessary tool in potential sixth wave, experts say"
            )
        )


        return arrayList
    }

}