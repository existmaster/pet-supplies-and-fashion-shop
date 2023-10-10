<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>주문 관리 &nbsp; ></div>
            <div>&nbsp; 주문</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="manageOrders" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                <v-icon small>mdi-minus-circle-outline</v-icon>주문 관리
            </v-btn>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','productId','quantity','shippingAddress','paymentMethod',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="productId" header="상품 아이디" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="quantity" header="수량" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="shippingAddress" header="배송 주소" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="paymentMethod" header="결제 수단" width="2*" :isReadOnly="true" align="center" />
        </wj-flex-grid>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">주문 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <Order :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
                        @click="closeDialog()"
                        depressed
                        icon 
                        absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'orderGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'orders',
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'productId': '',
                        'quantity': 0,
                        'shippingAddress': {},
                        'paymentMethod': '',
                    }
                }
            }
        }
    },
    methods:{
        manageOrders(){
            try{
                this.repository.invoke(this.getSelectedItem(), "manageOrders", null)
                this.$EventBus.$emit('show-success','ManageOrders 성공적으로 처리되었습니다.')
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
        },
    }
}
</script>