.PHONY: pdf clean

DIAS=$(wildcard *.dia)
FIGS=$(wildcard *.fig)
EPSS=$(wildcard *.eps)
SVGS=$(wildcard *.svg)

OUTPUT_EPS=$(DIAS:dia=eps) $(FIGS:fig=eps) $(SVGS:svg=eps) $(EPSS)
OUTPUT_PDF=$(OUTPUT_EPS:eps=pdf)

pdf: $(OUTPUT_PDF)

clean:
	rm -f if $(OUTPUT_PDF) $(DIAS:dia=eps) $(PNGS:png=eps) $(SVGS:svg=eps) 2>/dev/null; true
	rm -f $(FIGS:fig=eps) 2>/dev/null; true

%.pdf: %.eps
	epstopdf $<

%.eps: %.svg
	inkscape --export-text-to-path --export-eps $@ $<

%.eps: %.dia
	dia --nosplash -e $@ $<

%.eps: %.fig
	fig2dev -L eps $< $@
