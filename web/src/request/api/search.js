import service from '../index'

export function getInfo(){
    return service({
        method:'get',
        url:'',
    })
}