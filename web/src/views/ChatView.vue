<template>
    <div class="chat">
        <div class="left">
            <div class="left_top">
               <input type="text" class="search_input" placeholder="搜索"> 
               <div class="search_icon">+</div>
            </div>
            <hr/>
            <div class="left_middle">好友</div>
            <hr/>
        </div>
        <div class="right">
            right
        </div>
    </div>
</template>

<script>
</script>

<style scoped>
/* 布局样式 */
.chat{
    width: 1000px;
    min-height: 500px;
    max-height: 600px;
    margin: 10px auto;
    display: flex;
    border: 1px solid black;
    border-radius: 5px;
}

hr{
    margin-top: 8px;
    margin-bottom: 8px;
}

/* 左侧布局 */
.left{
    width: 30%;
    background-color: rgba(211, 211, 211, 0.326);
}

.left_top{
    display: flex;
    height: 30px;
    margin-top: 10px;
    margin-left: 10px;
}

.search_input{
    padding-left: 5px;
}

.search_icon{
    background-color: lightgrey;
    width: 30px;
    height: 30px;
    padding-left: 9px;
    padding-top: 2px;
    margin-left: 10px;
}

.left_middle{
    height: 30px;
    padding-left: 30px;
    padding-top: 3px;
}
</style>













<!-- <template>
    <div>
        <form onSubmit="return false;">
            <h3>BBS聊天室</h3>
            <textarea id="responseText" style="width: 1024px;height: 300px;"></textarea>
            <br/>
            <br/>
            <label>昵称 : </label><input v-model="username" type="text" id="uid"/> &nbsp;
            <input type="button" value="加入聊天室" @click="join" /> &nbsp;
            <input type="button" value="离开聊天室" @click="exit" />
            <br/>
            <br/>
            <label>消息 : </label><input type="text" id="message" /> &nbsp; <input type="button" value="发送消息" @click="send()" />
        </form>
    </div>
</template>

<script>
import { ref } from 'vue';

export default{
    setup(){
        const urlPrefix ='ws://localhost:3000/chat/';
        var ws = null;
        let username = ref('');

        console.log(username.value);

        const test =()=>{
            console.log('test');
        }


        //加入
        const join = ()=>{
            console.log('join');
            console.log(username.value);
            var url = urlPrefix + username.value;
            ws = new WebSocket(url);
            ws.onmessage = function(event){
                var ta = document.getElementById('responseText');
                ta.value += event.data+"\r\n";
            };
            ws.onopen = function(){
                var ta = document.getElementById('responseText');
                ta.value += "建立 websocket 连接... \r\n";
            };
            ws.onclose = function(){
                var ta = document.getElementById('responseText');
                ta.value += "用户["+username.value+"] 已经离开聊天室! \r\n";
                ta.value += "关闭 websocket 连接. \r\n";
            };
        }

        //退出
        const exit = ()=>{
            if(ws) {
                ws.close();
            }
        }

        // 发送信息
        const send = ()=>{
            var message = document.getElementById('message').value;
            if(!window.WebSocket){return;}
            if(ws.readyState == WebSocket.OPEN){
                ws.send(message);
            }else{
                alert("WebSocket 连接没有建立成功！");
            }
        }

        return{
            join,
            exit, 
            send,
            test,
            username,
        }
    }
}
</script>

<style scoped>
</style> -->