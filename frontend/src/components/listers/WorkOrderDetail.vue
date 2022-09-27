<template>
    <v-card outlined>
        <v-card-title>
            WorkOrder # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="EqmtId" v-model="item.eqmtId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PrcsId" v-model="item.prcsId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PrcsSqn" v-model="item.prcsSqn" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PrcsNm" v-model="item.prcsNm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PrdtCd" v-model="item.prdtCd" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RegDt" v-model="item.regDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RegNm" v-model="item.regNm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ItmNo" v-model="item.itmNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ItmNm" v-model="item.itmNm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ItmStd" v-model="item.itmStd" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrdrAmnt" v-model="item.ordrAmnt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OrdrDt" v-model="item.ordrDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OrdrYmd" v-model="item.ordrYmd" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="DlvrDt" v-model="item.dlvrDt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'WorkOrderDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/workOrders/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
