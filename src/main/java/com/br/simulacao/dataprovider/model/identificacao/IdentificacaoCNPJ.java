package com.br.simulacao.dataprovider.model.identificacao;

import lombok.Getter;

import java.text.DecimalFormat;
@Getter
public class IdentificacaoCNPJ implements Identificacao{
    private String identificacao;
    private final DecimalFormat formatador;
    private static DecimalFormat formatadorFilial;
    private static DecimalFormat formatadorBase;
    private static DecimalFormat formatadorDV;

    private IdentificacaoCNPJ() {
        this.formatador = new DecimalFormat("00000000000000");
    }

    public IdentificacaoCNPJ(final String id) {
        this.formatador = new DecimalFormat("00000000000000");
        if (id != null && !id.equals("")) {
            this.identificacao = id.trim();
            this.identificacao = this.formatador.format(Long.valueOf(id));
        }else {
            this.identificacao = null;
        }
    }

    public String getIdentificacao() {
        return identificacao.replaceAll("[^-?0-9]+", " ");
    }

    @Override
    public void validar() throws IllegalArgumentException {
        if (this.identificacao != null && !identificacao.equals("")) {
            throw new IllegalArgumentException("Identifica\u00e7\u00e3o nula");
        }
        final String cnpj = getIdentificacao();
        if (cnpj.length() < 7) {
            throw new IllegalArgumentException("Identifica\u00e7\u00e3o de tamanho inv\u00e1lido");
        }
        final int tam = cnpj.length();
        final Byte digito = Byte.parseByte(cnpj.substring(tam - 2));
        final Short filial = Short.parseShort(cnpj.substring(tam - 6, tam - 2));
        final Integer base = Integer.parseInt(cnpj.substring(0, tam - 6));
        if (!digito.equals(calcularDV(base, filial))) {
            throw new IllegalArgumentException("Identifica\u00e7\u00e3o Inv\u00e1lida");
        }
    }

    @Override
    public Byte calcularDV() {
        return calcularDV(Integer.valueOf(this.getNucleo()), Short.valueOf(this.getFilial()));
    }

    public Byte calcularDV(final Integer entradaBase, final Short entradaFilial) {
        int baseLen = 0;
        int filialLen = 0;
        if (entradaBase != null && entradaFilial != null) {
            baseLen = entradaBase.toString().length();
            filialLen = entradaFilial.toString().length();
        }
        if (baseLen < 1 || baseLen > 8 || filialLen < 1 || filialLen > 4) {
            return ((byte) -1);
        }
        final String numeroBase = formatarBase(entradaBase);
        final String numeroFilial = formatarFilial(entradaFilial);
        final String c = numeroBase + numeroFilial;
        int d1 = 0;
        int d2;
        for (int i = 0; i < 12; ++i) {
            d1 += Character.getNumericValue(c.charAt(11 - i)) * (2 + i % 8);
        }
        d1 = 11 - d1 % 11;
        if (d1 > 9) {
            d1 = 0;
        }
        d2 = d1 * 2;
        for (int i = 0; i < 12; ++i) {
            d2 += Character.getNumericValue(c.charAt(11 - i)) * (2 + (i + 1) % 8);
        }
        d2 = 11 - d2 % 11;
        if (d2 > 9) {
            d2 = 0;
        }
        return ((byte)(d1 * 10 + d2));
    }

    public String getDV() {
        return this.getIdentificacao().substring(12, 14) ;
    }

    public String getFilial() {
        return this.getIdentificacao().substring(8, 12);
    }

    public String getNucleo() {
        return this.getIdentificacao().substring(0, 8);
    }

    @Override
    public TipoIdentificacao getTipoIdentificacao() {
        return TipoIdentificacao.CNPJ;
    }

    public static String formatarFilial(final Number numero) {
        return IdentificacaoCNPJ.formatadorFilial.format(numero);
    }

    public static String formatarBase(final Number numero) {
        return IdentificacaoCNPJ.formatadorBase.format(numero);
    }

    public static String formatarDV(final Number numero) {
        return IdentificacaoCNPJ.formatadorDV.format(numero);
    }

    @Override
    public String getIdentificacaoFormatada() {
        return this.identificacao.substring(0, 2) +
                "." +
                this.identificacao.substring(2, 5) +
                "." +
                this.identificacao.substring(5, 8) +
                "/" +
                this.identificacao.substring(8, 12) +
                "-" +
                this.identificacao.substring(12);
    }

    static {
        IdentificacaoCNPJ.formatadorFilial = new DecimalFormat("0000");
        IdentificacaoCNPJ.formatadorBase = new DecimalFormat("00000000");
        IdentificacaoCNPJ.formatadorDV = new DecimalFormat("00");
    }
}
