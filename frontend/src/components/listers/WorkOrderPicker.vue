<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="indigo"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="grey darken-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                EqmtId :  {{item.eqmtId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrcsId :  {{item.prcsId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrcsSqn :  {{item.prcsSqn }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrcsNm :  {{item.prcsNm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrdtCd :  {{item.prdtCd }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RegDt :  {{item.regDt }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RegNm :  {{item.regNm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ItmNo :  {{item.itmNo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ItmNm :  {{item.itmNm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ItmStd :  {{item.itmStd }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OrdrAmnt :  {{item.ordrAmnt }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OrdrDt :  {{item.ordrDt }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OrdrYmd :  {{item.ordrYmd }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DlvrDt :  {{item.dlvrDt }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="indigo"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'WorkOrderPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/workOrders'))
            if(temp.data) {
                me.list = temp.data._embedded.workOrders;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/workOrders/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['id'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

