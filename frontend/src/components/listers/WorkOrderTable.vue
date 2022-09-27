<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="blue"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <WorkOrder :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
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
    const axios = require('axios').default;
    import WorkOrder from './../WorkOrder.vue';

    export default {
        name: 'WorkOrderManager',
        components: {
            WorkOrder,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "id", value: "id" },
                    { text: "eqmtId", value: "eqmtId" },
                    { text: "prcsId", value: "prcsId" },
                    { text: "prcsSqn", value: "prcsSqn" },
                    { text: "prcsNm", value: "prcsNm" },
                    { text: "prdtCd", value: "prdtCd" },
                    { text: "regDt", value: "regDt" },
                    { text: "regNm", value: "regNm" },
                    { text: "itmNo", value: "itmNo" },
                    { text: "itmNm", value: "itmNm" },
                    { text: "itmStd", value: "itmStd" },
                    { text: "ordrAmnt", value: "ordrAmnt" },
                    { text: "ordrDt", value: "ordrDt" },
                    { text: "ordrYmd", value: "ordrYmd" },
                    { text: "dlvrDt", value: "dlvrDt" },
                ],
            workOrder : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/workorders'))
            temp.data._embedded.workorders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.workorders;

            this.newValue = {
                'eqmtId': 0,
                'prcsId': '',
                'prcsSqn': '',
                'prcsNm': '',
                'prdtCd': '',
                'regDt': '2022-09-27',
                'regNm': '',
                'itmNo': '',
                'itmNm': '',
                'itmStd': '',
                'ordrAmnt': '',
                'ordrDt': '2022-09-27',
                'ordrYmd': '2022-09-27',
                'dlvrDt': '2022-09-27',
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

