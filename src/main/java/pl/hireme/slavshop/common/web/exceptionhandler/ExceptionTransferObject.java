package pl.hireme.slavshop.common.web.exceptionhandler;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ExceptionTransferObject {

    @NonNull
    private String description;

}
