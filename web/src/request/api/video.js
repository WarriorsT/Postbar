import service from '@/request'

export function getVideos(){
    return service({
        method:'get',
        url:'/videos',
    })
}

export function getUsername(){
    return service({
        method:'get',
        url:'/video/user',
    })
}

