
import { Pipe, PipeTransform } from '@angular/core';

@Pipe ({
    name : 'cutString' 
})

export class CustStringPipe implements PipeTransform {
    transform(data: string, length: number) {
        return data.substr(0, length) +  ' ... '
    } 
}