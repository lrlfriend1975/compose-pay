/*
 * Copyright © 2020 pleuvoir (pleuvior@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.pleuvoir.gateway.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 支付入参父类
 *
 * @author <a href="mailto:fuwei@daojia-inc.com">pleuvoir</a>
 */
@Data
public class PayBaseRequestDTO implements Serializable {

    private static final long serialVersionUID = -1699831686561099489L;

    @Length(max = 15)
    @NotBlank(message = "商户号不能为空")
    private String mid;            //商户号

    @Length(max = 32)
    @NotBlank(message = "商户订单号不能为空")
    private String orderNo;        //商户系统中的订单号

    @NotEmpty(message = "交易唯一ID不能为空")
    private Long transUniqueId;  //交易唯一ID，支持同一笔业务订单发起多次支付请求

    @Length(max = 128)
    @NotBlank(message = "商品名称不能为空")
    private String subject;        //商品名称

    @Length(max = 128)
    @NotBlank(message = "描述不能为空")
    private String body;        //描述

    @Digits(integer = 10, fraction = 2)
    @DecimalMin(value = "0.01", message = "金额必须大于或等于0.01")
    private BigDecimal amount;        //金额

    @NotBlank(message = "支付种类不能为空")
    private String payType;

    @NotBlank(message = "支付方式不能为空")
    private String payWay;

    @Length(max = 256)
    @NotBlank(message = "商户通知地址不能为空")
    private String notifyUrl;    //商户通知地址

    private String ip;


}
