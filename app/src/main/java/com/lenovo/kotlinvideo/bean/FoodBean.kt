package com.lenovo.kotlinvideo.bean

import java.io.Serializable

class FoodBean : Serializable {

    var resultcode: String? = null
    var reason: String? = null
    var error_code: Int = 0
    var result: List<ResultBean>? = null

    class ResultBean {
        /**
         * parentId : 10001
         * name : 菜式菜品
         * list : [{"id":"1","name":"家常菜","parentId":"10001"},{"id":"2","name":"快手菜","parentId":"10001"},{"id":"3","name":"创意菜","parentId":"10001"},{"id":"4","name":"素菜","parentId":"10001"},{"id":"5","name":"凉菜","parentId":"10001"},{"id":"6","name":"烘焙","parentId":"10001"},{"id":"7","name":"面食","parentId":"10001"},{"id":"8","name":"汤","parentId":"10001"},{"id":"9","name":"自制调味料","parentId":"10001"}]
         */

        var parentId: String? = null
        var name: String? = null
        var list: List<ListBean>? = null

        class ListBean {
            /**
             * id : 1
             * name : 家常菜
             * parentId : 10001
             */

            var id: String? = null
            var name: String? = null
            var parentId: String? = null
        }
    }
}
