<template>
    <v-card outlined>
        <v-card-title>
            Materials # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CoptrPrdtCd" v-model="item.coptrPrdtCd" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CoptrItmNo" v-model="item.coptrItmNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CoptrItmNm" v-model="item.coptrItmNm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CoptrItmStd" v-model="item.coptrItmStd" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CoptrWrhsCnt" v-model="item.coptrWrhsCnt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CoptrCd" v-model="item.coptrCd" :editMode="editMode" @change="change" />
            </div>
            <Production offline label="Production" v-model="item.production" :editMode="false" :key="false" @change="change" />
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
        name: 'MaterialsDetail',
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
            var temp = await axios.get(axios.fixUrl('/materials/' + params.id))
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
