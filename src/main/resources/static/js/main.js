var messageApi = Vue.resource('/product{/id}');

Vue.component('product-list', {
    props: ['products'],
    template: '<div><div v-for="product in products">{{product.id}} {{ product.name }}</div></div>'
})

var app = new Vue({
    el: '#app',
    template: '<product-list :products="products"/>',
    data: {
        products: [
            {id: 1, name: 'first'},
            {id: 2, name: 'second'}
        ]
    },
    created: function () {
        messageApi.get().then(result =>
            console.log(result)
        )
    }

});