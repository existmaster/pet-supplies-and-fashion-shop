<template>
    <div>
        <String label="상품 아이디" v-model="value.productId" :editMode="editMode"/>
        <Number label="수량" v-model="value.quantity" :editMode="editMode"/>
        <String label="결제 수단" v-model="value.paymentMethod" :editMode="editMode"/>
        <Address offline label="배송 주소" v-model="value.shippingAddress" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Order',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

